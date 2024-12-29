# Description

This example shows how to integrate msw browser into react vite project

```shell
npm create vite@latest msw-vite --template react
cd msw-vite 

npm install

# use cross-env to set the NODE_ENV
npm install cross-env --save-dev

npx msw init <PUBLIC_DIR> --save
```
