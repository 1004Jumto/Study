import "./App.css";
import Header from "../component/Header";
import TodoEditor from "../component/TodoEditor";
import TodoList from "../component/TodoList";
import { useReducer, useRef, useState } from "react";
import TestComp from "../component/TestComp";

function reducer(state, action) {
  switch (action.type) {
    case "CREATE": {
      return [action.newItem, ...state];
    }
    case "UPDATE": {
      return state.map((it) =>
        it.id === action.targetId ? { ...it, isDone: !it.isDone } : it,
      );
    }
    case "DELETE": {
      return state.filter((it) => it.id !== action.targetId);
    }
    default:
      return state;
  }
}

function App() {
  const [todo, dispatch] = useReducer(reducer, mockTodo);
  const idRef = useRef(3);

  const onCreate = (content) => {
    // const newItem = {
    //   id: idRef.current,
    //   content: content,
    //   isDone: false,
    //   createdDate: new Date().getTime(),
    // };
    // setTodo([newItem, ...todo]);

    dispatch({
      type: "CREATE",
      newItem: {
        id: idRef,
        content,
        isDone: false,
        createdDate: new Date().getTime(),
      },
    });

    idRef.current += 1;
  };

  const onUpdate = (targetId) => {
    // setTodo(
    //   todo.map((it) => {
    //     if (it.id === targetId) {
    //       return {
    //         ...it,
    //         isDone: !it.isDone,
    //       };
    //     } else {
    //       return it;
    //     }
    //   }),
    // );

    dispatch({
      type: "UPDATE",
      targetId,
    });
  };

  const onDelete = (targetId) => {
    // setTodo(todo.filter((it) => it.id !== targetId));

    dispatch({
      type: "DELETE",
      targetId,
    });
  };

  return (
    <div className="App">
      <Header />
      <TestComp />
      <TodoEditor onCreate={onCreate} />
      <TodoList todo={todo} onUpdate={onUpdate} onDelete={onDelete} />
    </div>
  );
}

const mockTodo = [
  {
    id: 0,
    isDone: false,
    content: "지원서 작성하기",
    createdDate: new Date().getTime(),
  },
  {
    id: 1,
    isDone: false,
    content: "그림 그리기",
    createdDate: new Date().getTime(),
  },
  {
    id: 2,
    isDone: false,
    content: "코딩테스트/CS 공부하기",
    createdDate: new Date().getTime(),
  },
];
export default App;
