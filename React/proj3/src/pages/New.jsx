import { useSearchParams } from "react-router-dom";
import Button from "../component/Button";
import Header from "../component/Header";
import Editor from "../component/Editor";
import { useContext, useEffect, useState } from "react";
import { getMonthRangeByDate } from "../util";
import { DiaryDispatchContext, DiaryStateContext } from "../App";
import DiaryList from "../component/DiaryList";
import { useNavigate, useParams } from "react-router-dom";
import useDiary from "../hooks/useDiary";
import { getFormattedDate } from "../util";

const New = () => {
  const navigate = useNavigate();
  const { onCreate } = useContext(DiaryDispatchContext);

  const goBack = () => {
    navigate(-1);
  };

  const onSubmit = (data) => {
    const { date, content, emotionId } = data;
    onCreate(date, content, emotionId);
    navigate("/", { replace: true });
  };

  return (
    <div>
      <Header
        title={"새 일기쓰기"}
        leftChild={<Button onClick={goBack} text={"< 뒤로가기"} />}
      />
      <Editor onSubmit={onSubmit} />
    </div>
  );
};
export default New;
