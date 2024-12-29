"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
let size = "small";
console.log(typeof size);
let location = { x: 10, y: 20 };
console.log("location type " + typeof location);
// Type from Func Return
const createSize = (size) => {
    return size;
};
let fixedSize = "small";
console.log("fixedSize type " + typeof fixedSize);
