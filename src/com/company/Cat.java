package com.company;

public class Cat implements Cloneable
{
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    //для УРОКА №3 статическое поле
    private static int count=0;

    //УРОК №4, создадим константы
    final static double MIN_WEIGHT = 1000.0;
    final static double MAX_WEIGHT = 9000.0;
    //ENUM с окрасами
    enum ColorOfTheCat {
        BlackTabby, FawnTarry, BlueTabby, ChocolateTabby
    }
    // геттеры и сеттеры для окраса кошки для урока №6
    public ColorOfTheCat getColorOfTheCat() {
        return colorOfTheCat;
    }

    public void setColorOfTheCat(ColorOfTheCat colorOfTheCat) {
        this.colorOfTheCat = colorOfTheCat;
    }

    //Урок №6
    //переменная для окраса
    private ColorOfTheCat colorOfTheCat;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        //Используем константы из урока №4
        //minWeight = 1000.0;
        //maxWeight = 9000.0;
        minWeight = MIN_WEIGHT;
        maxWeight = MAX_WEIGHT;

        //увеличиваем значение count в момент создания кошки
        //делаем кошку "живой"
        count++;
    }

    // Создадим конструктор для урока №5

    public Cat(double weight) {
        this.weight = weight;
        originWeight = weight;
    }

    public void meow()
    {
        //запретим мяукать неживой кошке
        if (weight<minWeight) {
            System.out.println("Неживая кошка не может мяукать");
        }
        else {
            weight = weight - 1;
            System.out.println("Meow");
        }
    }

    public void feed(Double amount)
    {
        //запретим есть неживой кошке
        if (weight<minWeight) {
            System.out.println("Нельзя кормить неживую кошку");
        }
        else weight = weight + amount;
    }

    public void drink(Double amount)
    {
        //запретим пить неживой кошке
        if (weight<minWeight){
           System.out.println("Нельзя поить неживую кошку");
        }
        else weight = weight + amount;
    }

    public double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
    //методы для второго урока
    //возврат суммы съеденной еды
    public double getFoodEaten(){
        return weight-originWeight;
    }
    //метод "сходить в туалет"
    public void pee(){
        //запретим ходить в туалет неживой кошке
        if (weight<minWeight) {
            System.out.println("Неживая кошка не может ходить в туалет");
        }
        else {
            originWeight-=10;
            weight-=10;
            System.out.println("Хозяин, я сходила в туалет, мяу!");
        }
    }

    //УРОК №3
    //метод, который возвращает количество кошек
    public static int getCount(){
        return count;
    }
    //метод проверки "состояния" кошки
    public void aliveOrNot(){
        if (weight<minWeight){
            count--;
        }
    }
    public Cat(double originWeight, double weight, double minWeight, double maxWeight, ColorOfTheCat colorOfTheCat) {
        this.originWeight = originWeight;
        this.weight = weight;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.colorOfTheCat = colorOfTheCat;
    }
    public double getOriginWeight() {
        return originWeight;
    }
    //Урок №7
    // создадим метод для "копирования" кошки,
    public Cat clone() throws CloneNotSupportedException{
        return (Cat)super.clone();
    }

    public double getMinWeight() {
        return minWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    //а также конструктор для копирования кошки
    public Cat(Cat cat)
    {
       this(cat.getOriginWeight(),cat.getWeight(),
               cat.getMinWeight(),cat.getMaxWeight(),
               cat.getColorOfTheCat());
    }
}