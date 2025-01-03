import React from "react";
import { createRoot } from "react-dom/client";
import { Provider } from "react-redux";

import App from "./App";
import { store } from "./app/store";
import { fetchUsers } from "./features/users/usersSlice";

import { worker } from "./api/server";

import "./index.css";
import "./primitiveui.css";

// Wrap app rendering so we can wait for the mock API to initialize
async function start() {
  // Start our mock API server
  await worker.start({ onUnhandledRequest: "bypass" });

  store.dispatch(fetchUsers());

  const root = createRoot(document.getElementById("root")!);

  root.render(
    <React.StrictMode>
      <Provider store={store}>
        <App />
      </Provider>
    </React.StrictMode>
  );
}

start();
