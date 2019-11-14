package com.todolist.models.repository;

import com.todolist.dto.Event;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository(value = "EventDaoImpl")
public class EventDaoImpl implements IEventDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Event> getAllEvents() {
        return em.createQuery("from Event").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Event findEvent(Long id) {
        return em.find(Event.class, id);
    }

    // Method created to add new events and to edit events already persisted
    @Transactional //Without readOnly, because we want to be able to write in it
    @Override
    public void saveNewEvent(Event event) {
        if(event.getId() != null && event.getId() > 0) {
            em.merge(event); // edit event
        } else {
            em.persist(event); // insert and save new event
        }
    }

    @Override
    @Transactional
    public void deleteEvent(Long id) {
        em.remove(findEvent(id));
    }


}
