
# Redux Simple

1. create vite project
```shell
npm create vite@latest redux-simple --template react
cd redux-simple;
npm install @reduxjs/toolkit react-redux

```

2. create redux store
```javascript
// src/store/store.js
import { configureStore } from '@reduxjs/toolkit'

export const store = configureStore({
  reducer: {} // We'll add reducers here later
})
```



# Redux Essential

1. create vite project
```shell
npm create vite@latest redux-essential --template react
cd redux-essential;
npm install @reduxjs/toolkit react-redux

```