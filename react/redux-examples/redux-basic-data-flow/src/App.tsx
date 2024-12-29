import { Route, BrowserRouter as Router, Routes } from "react-router-dom";

import { Navbar } from "@/components/Navbar";
import { AddPostForm } from "@/features/posts/AddPostForm";
import { PostsList } from "@/features/posts/PostsList";

function App() {
  return (
    <Router>
      <Navbar />
      <div className="App">
        <Routes>
          <Route
            path="/"
            element={
              <>
                <AddPostForm />
                <PostsList />
              </>
            }
          ></Route>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
