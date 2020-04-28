let a = 0;
const b = 12;
let c; //undefined

//1
let obj1 = {};
obj1.name = "Vasya";
obj1.color = "grey";

//2
let obj2 = {
    name: "Petr",
    color: "Grey"
}

//no need to be the same kind of the object
obj1 = 1;

//functions
let age = 5;
function mau() {
    console.log(age);
    console.log("Mau!!! I am " + this.name);
}

obj1.mau = mau;

let cat = {
    name: "Petr",
    color: "Grey",
}