let vasilyAnimal = {
    name: "Vasily",
    eat: function () {
        console.log("Eating!!");
    }
}

let vasilyCat = {
    mau: function () {
        console.log("Mau!!! I am " + this.name)
    },
    //1 inheritance
    __proto__: vasilyAnimal
}

//2 inheritance
Object.setPrototypeOf(vasilyCat, vasilyAnimal);

//creation typical object

//1 function
function catFactory(name, color) {
    let newCat = {}
    newCat.name = name;
    newCat.color = color;
    newCat.mau = function () {
        console.log(`Mau!!! My name is ${this.name}`);
    }

    return newCat;
}

//without new!!
let vasya = catFactory("Vasya", "grey");

//2 construct function (constructor)
function Cat(name, color) {
    this.name = name;
    this.color = color;
    this.mau = function () {
        console.log(`Mau!!! My name is ${this.name}`);
    }
}

let vasyaConstructor = new Cat("VasyaConstructor", "grey");

//inheritance with constructor functions
function Animal(name) {
    this.name = name;
    this.eat = function () {
        console.log("Eating!!!");
    }
}

// Animal.prototype.eat ;
let animal = new Animal("Rrrr");

function CatAnimal(name, color) {
    Animal.apply(this, arguments);
    this.color = color;
    this.mau = function () {
        console.log(`Mau!!! My name is ${this.name}`);
    }
}

//classes
class AnimalClass {
    constructor(name) {
        this.name = name;
    }

    eat () {
        console.log("Eating!!!");
    }
}

class CatClass extends AnimalClass {
    constructor(name, color) {
        super(name);
        this.color = color;
    }
    mau () {
        console.log("Mau!!" +this.name);
    }
}