type Size = "small" | "medium" | number;

let size: Size = "small";

console.log(typeof size);

type Location = { x: number } & { y: number };

let location: Location = { x: 10, y: 20 };

console.log("location type " + typeof location);

// Type from Func Return

const createSize = (size: Size) => {
  return size;
};

type fixedSize = ReturnType<typeof createSize>;

let fixedSize: fixedSize = "small";

console.log("fixedSize type " + typeof fixedSize);


