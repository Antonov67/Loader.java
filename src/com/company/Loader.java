package com.company;

import java.util.Arrays;

public class Loader
{
    public static void main(String[] args)
    {
        //УРОК №1

        //создадим 7 кошек, можно отдельно, но короче массивом и циклом
        //и сразу выведем в консоль их вес
        Cat[] cats = new Cat[7];
        for(int i=0;i<7;i++){
            cats[i] = new Cat();
            System.out.println("Вес кошки №" + (i+1) + " " + cats[i].getWeight());
            //округлим и оставим 2 знака после запятой
            System.out.print("Вес кошки №" + (i+1) + " ");
            System.out.printf("%.2f",cats[i].getWeight());
            System.out.println();
        }
        //покормим первую и последнюю кошку
        cats[0].feed(150.0);
        cats[6].feed(250.0);
        //новый увеличенный вес кошек
        System.out.println("Вес кошки №1 " + cats[0].getWeight());
        System.out.println("Вес кошки №7 " + cats[6].getWeight());
        //перекормим кошку №2
        while (!cats[1].getStatus().equals("Exploded")){
            cats[1].feed(10.0);
        }
        //проверим вес перекормленной кошки, он должен быть больше 9000
        System.out.println("Вес перекормленной кошки №2 " + cats[1].getWeight());
        //замяукаем кошку №3 до смерти
        while (!cats[2].getStatus().equals("Dead")){
            cats[2].meow();
        }
        //проверим вес замяуканной кошки, он должен быть меньше 1000
        System.out.println("Вес замяуканной кошки №3 " + cats[2].getWeight());

        //УРОК №2
        //создадим кошку и покормим ее кормом весом 150.00
        Cat cat8 = new Cat();
        cat8.feed(150.00);
        //сходим в туалет 5 раз
        int n=0;
        while (n<5){
            cat8.pee();
            n++;
        }
        //распечатаем значение съеденного корма
        System.out.println(cat8.getFoodEaten());

        //УРОК №3

        //количество кошек на момент запуска программы
        System.out.println("Кошек всего было создано " + Cat.getCount());

        /*проверим сколько кошек создано на данный момент
                для этого применим метод aliveOrNot()
                к каждой созданной кошке
         */
        for (int i=0;i<7;i++){
            cats[i].aliveOrNot();
        }
        cat8.aliveOrNot();
        //выведем на экран итоговое значение с помощью метода getCount()
        System.out.println("Живых кошек на данный момент " + Cat.getCount());
        //проверим, что нельзя кормить, поить и т.д. неживую кошку №3
        cats[2].pee();
        cats[2].feed(100.0);
        cats[2].drink(100.0);
        cats[2].meow();

        //УРОК №4
        //выведем на экран, созданные константы и ENUM
        System.out.println(Cat.MAX_WEIGHT);
        System.out.println(Cat.MIN_WEIGHT);
        //Выведем ENUN с окрасами кошек
        System.out.println(Arrays.toString(Cat.ColorOfTheCat.values()));

        //УРОК №5
        //создадим 9 кошку, используя новый конструктор
        Cat cat9 = new Cat(3000.00);
        System.out.println("Вес 9 кошки " + cat9.getWeight());
        //используем метод getKitten() и выведем на экран вес котёнка
        System.out.println("вес котёнка " + getKitten().getWeight());

        //УРОК №6
        //зададим и считаем окрас кошки
        cat9.setColorOfTheCat(Cat.ColorOfTheCat.ChocolateTabby);
        System.out.println("цвет кошки " + cat9.getColorOfTheCat());

        //Урок №7
        //проведем копирование кошки двумя способами
        //конструктором
        Cat cat10 = new Cat(cat9);
        System.out.println("оригинал " + cat9.getWeight() + " " +
                cat9.getColorOfTheCat());
        System.out.println("копия " + cat10.getWeight() + " " +
                cat10.getColorOfTheCat());
        //методом
        Cat cat11 = null;
        try {
            cat11 = cat9.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("оригинал " + cat9.getWeight() + " " +
                cat9.getColorOfTheCat());
        System.out.println("копия " + cat11.getWeight() + " " +
                cat11.getColorOfTheCat());
        //изменим объект cat9 и проверим, что это не повлияло на
        //cat10 и cat11
        cat9.pee();
        cat9.pee();
        System.out.println("оригинал " + cat9.getWeight() + " " +
                cat9.getColorOfTheCat());
        System.out.println("копия cat10 " + cat10.getWeight() + " " +
                cat10.getColorOfTheCat());
        System.out.println("копия cat11 " + cat11.getWeight() + " " +
                cat11.getColorOfTheCat());

    }

    //для 5 урока
    private static Cat getKitten(){
        return new Cat(1100.00);
    }
}
