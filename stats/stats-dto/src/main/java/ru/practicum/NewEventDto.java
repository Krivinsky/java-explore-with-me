package ru.practicum;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class NewEventDto {

    @Min (20)
    @Max(2000)
    private String annotation;  //Краткое описание события

    private int category;  //id категории к которой относится событие

    @Min(20)
    @Max(7000)
    private String description;  //Полное описание события

    String eventDate; //Дата и время события - yyyy-MM-dd HH:mm:ss

    Location location; //Широта и долгота места проведения события

    boolean paid;   //Платное ли событие

    int participantLimit;  //Ограничение на количество участников. Значение 0 - означает отсутствие ограничения

    /*Нужна ли пре-модерация заявок на участие.
    Если true, то все заявки будут ожидать подтверждения инициатором события.
    Если false - то будут подтверждаться автоматически.
    */
    boolean requestModeration;

    @Min(3)
    @Max(120)
    String title;  //Заголовок события

}
