package com.company;

enum Months {

    Январь(1),
    Февраль(2),
    Март(3),
    Апрель(4),
    Май(5),
    Июнь(6),
    Июль(7),
    Август(8),
    Сентябрь(9),
    Октябрь(10),
    Ноябрь(11),
    Декабрь(12);

    private int value;

    Months(int value) {
        this.value = value;
    }


}