import Header from "../component/Header";
import Button from "../component/Button";
import { replace, useNavigate, useParams } from "react-router-dom";
import useDiary from "../hooks/useDiary";
import { useContext } from "react";
import { DiaryDispatchContext } from "../App";
import Editor from "../component/Editor";

const Edit = () => {
  const { id } = useParams();
  const data = useDiary(id);
  const navigate = useNavigate();
  const { onDelete, onUpdate } = useContext(DiaryDispatchContext);

  const goBack = () => {
    navigate(-1);
  };

  const onClickDelete = () => {
    if (window.confirm("일기를 정말 삭제할까요? 다시 복구되지 않아요!")) {
      onDelete(id);
      navigate("/", { replace: true });
    }
  };

  const onSubmit = (data) => {
    if (window.confirm("일기를 수정할까요?")) {
      const { date, content, emotionId } = data;
      onUpdate(id, date, content, emotionId);
      navigate("/", { replace: true });
    }
  };

  if (!data) {
    return <div>일기를 불러오고 있습니다</div>;
  } else {
    return (
      <div>
        <Header
          title={"일기 수정하기"}
          leftChild={<Button onClick={goBack} text={"< 뒤로가기"} />}
          rightChild={
            <Button
              onClick={onClickDelete}
              type={"navigate"}
              text={"삭제하기"}
            />
          }
        />
        <Editor initData={data} onSubmit={onSubmit} />
      </div>
    );
  }
};
export default Edit;
