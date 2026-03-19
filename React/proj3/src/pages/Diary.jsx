import { useParams } from "react-router-dom";

const Diary = () => {
  const { id } = useParams();
  console.log(id);

  return (
    <div>
      <div>Diary 페이지입니다.</div>
      <div>{id}번 일기</div>
    </div>
  );
};
export default Diary;
