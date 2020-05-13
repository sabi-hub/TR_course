// alert("Hello world"); //dialog window
console.log("Hello world") //sout in JS
let name = "Vasya"; //variable
name = "Petya";

function sum(arg1, arg2) {
    return arg1 + arg2;
}

console.log(sum("Vasya", "Kot"));

let summ = function () {
    return arg1 + arg2;
}

let newSum = sum;
newSum(3, 8);

let anotherSum = summ;

let thirdSum = (arg1, arg2) => arg1 + arg2;

let counter = 0;

function increaseCounter(addition) {
    counter += addition;
}

let vasyaKot = {
    name: "Vasya",
    color: "grey",
    // mau:function()
    mau() {
        console.log("mau!!!, ich bin " + this.name);
    }
}

console.log(vasyaKot.name); //Vasya

let nameArg = "name";
console.log(vasyaKot[nameArg]);//Vasya

let array1 = [1, -10, 19, "Petya", function () {
    return "pam pam";
}]

console.log(array1[1]); //-10
array1.push(25);//add to the end
console.log(array1);
array1.pop();//cut/delete the last element
console.log(array1);
array1.shift(); //cut/delete the first element
console.log(array1);
array1.unshift(20); // add element to the begin
console.log(array1);

//constructor
function Cat(name, color) {
    this.color = color;
    this.name = name;
    this.mau = function () {
        console.log("mau!!!, ich bin " + this.name)
    }
}

let vasyan = new Cat("Vasyan", "blue");