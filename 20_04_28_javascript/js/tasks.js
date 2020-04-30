for (let i = 2; i <= 10; i++) {
    if (i % 2 != 0) continue;
    console.log(i);
}

for (let i = 0; i < 3; i++) {
    console.log(`number ${i}!`);
}

let i = 0;
while (i < 3) {
    console.log(`number ${i}!`);
    i++;
}

// let num;
// do {
//     num = prompt("Введите число, большее 100?", 0);
// } while (num <= 100 && num);

let n = 10;
nextPrime:
    for (let i = 2; i <= n; i++) { // Для всех i...
        for (let j = 2; j < i; j++) { // проверить, делится ли число..
            if (i % j == 0) continue nextPrime; // не подходит, берём следующее
        }
        console.log(i); // простое число
    }

function checkAge(age) {
    if (age > 18) {
        return true;
    } else {
        return confirm('Родители разрешили?');
    }
}

function checkAge(age) {
    return (age > 18) ? true : confirm('Родители разрешили?');
}

function min(a, b) {
    return (a < b) ? a : b;
}

// let num1 = prompt("Number1");
// let num2 = prompt("Number2");
//
// function pow(num1, num2) {
//     return num1 ** num2;
// }
// console.log(pow(num1,num2));

let user = {
    name: 'John',
    surname: 'Smith',
};
console.log(user.name);
user.name = 'Pete';
console.log(user.name);
delete user.name;
console.log('name' in user);

function isEmpty(obj) {
    for (let objKey in obj) {
        return false;
    }
    return true;
}

let user2 = {
    name: "Vasya"
};
console.log(isEmpty(user2));

let salaries = {
    John: 100,
    Ann: 160,
    Pete: 130
}

function sumOfSalaries(obj) {
    let counter = 0;
    for (let key in obj) {
        counter = counter + obj[key];
    }
    return counter;
}

console.log(sumOfSalaries(salaries));


function multiplyNumeric(obj) {
    for (let objKey in obj) {
        if (typeof (obj[objKey]) == "number") {
            obj[objKey] *= 2;
        }
    }
}

// до вызова функции
let menu = {
    width: 200,
    height: 300,
    title: "My menu"
};

console.log(multiplyNumeric(menu));

for (let menuKey in menu) {
    console.log(menu[menuKey]);
}

// после вызова функции
menu = {
    width: 400,
    height: 600,
    title: "My menu"
};


//read() (читать) запрашивает два значения и сохраняет их как свойства объекта.
// sum() (суммировать) возвращает сумму сохранённых значений.
// mul() (умножить) перемножает сохранённые значения и возвращает результат.
// let calculator = {
//     read(){
//         this.a = +prompt('a?', 0);
//         this.b = +prompt('b?', 0);
//     },
//     sum(){
//         return this.a+this.b;
//     },
//     mul(){
//       return this.a*this.b;
//     }
// };
//
// calculator.read();
// console.log( calculator.sum() );
// console.log( calculator.mul() );

// function Calculator(){
//     this.read = function(){
//         this.a = +prompt('a?', 0);
//          this.b = +prompt('b?', 0);
//     };
//     this.sum = function () {
//         return this.a+this.b;
//     }
//     this.mul = function () {
//         return this.a*this.b;
//     }
// }
// let calculator = new Calculator();
// calculator.read();
//
// console.log( "Sum=" + calculator.sum() );
// console.log( "Mul=" + calculator.mul() );


//     Объект, который она создаёт, должен уметь следующее:
//
//     Хранить «текущее значение» в свойстве value. Начальное значение устанавливается в аргументе конструктора startingValue.
//     Метод read() использует prompt для получения числа и прибавляет его к свойству value.
//     Таким образом, свойство value является текущей суммой всего, что ввёл пользователь при вызовах метода read(), с учётом начального значения startingValue.
//
//     Ниже вы можете посмотреть работу кода:
//
//

function Accumulator(startingValue) {
    this.value = startingValue;
    this.read = function () {
        this.value += +prompt('a?', 0);
    }
}
let accumulator = new Accumulator(1); // начальное значение 1

accumulator.read(); // прибавит ввод prompt к текущему значению
accumulator.read(); // прибавит ввод prompt к текущему значению

console.log(accumulator.value); // выведет сумму этих значений