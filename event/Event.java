/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.curstomerservice.event;

import java.io.Serializable;

/**
 *
 * @author siluk
 */
public class Event implements Serializable {

    private String EvId;

    private EventCode EventCode;

    private String Message;

    public String getEvId() {
        return EvId;
    }

    public void setEvId(String EvId) {
        this.EvId = EvId;
    }

    public EventCode getEventCode() {
        return EventCode;
    }

    public void setEventCode(EventCode EventCode) {
        this.EventCode = EventCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public Event(String EvId, String Message, EventCode EventCode) {
        this.EvId = EvId;
        this.EventCode = EventCode;
        this.Message = Message;
    }

    @Override
    public String toString() {
        return "Event{" + "EvId=" + EvId + ", EventCode=" + EventCode + ", Message=" + Message + '}';
    }

    public Event(String EvId, EventCode EventCode) {
        this.EvId = EvId;
        this.EventCode = EventCode;
    }

    public Event(String EvId) {
        this.EvId = EvId;
    }
}
