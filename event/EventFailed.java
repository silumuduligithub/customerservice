/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.curstomerservice.event;

/**
 *
 * @author siluk
 */
public class EventFailed extends Event{
     public EventFailed(String evId)
    {
        super(evId, EventCode.Failed);

    }
}
