import { styled } from 'styled-components';
import Profile from '../components/Profile';
import MyPageTab from '../components/MyPageTab';
import axios from 'axios';
import { useEffect, useState } from 'react';
//import { useSelector } from 'react-redux';

const MyPageSection = styled.section`
  width: 100vw;
  margin-top: 20px;
  margin-bottom: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

//레이아웃 부터 잡기!
const MyPage = () => {
  const [user, setUser] = useState({
    id: 0,
    nickname: '',
    email: '',
    gender: '',
    introduce: '',
    imageUrl: '',
    follower: 0,
    following: 0,
    applicants: [{ boardId: 0, imgUrl: '' }],
    boardLikes: [{ boardId: 0, imgUrl: '' }],
  });

  const [activetab, setActiveTab] = useState('tab1');
  const token = localStorage.getItem('jwtToken');
  //  const myId = useSelector((state) => state.user.myId);

  const fetchMyInfo = async () => {
    try {
      const response = await axios.get(`http://3.39.76.109:8080/members/me`, {
        headers: {
          Authorization: token,
        },
      });
      const myInfo = response.data;
      const userData = {
        id: myInfo.id,
        nickname: myInfo.nickname,
        email: myInfo.email,
        gender: myInfo.gender,
        introduce: myInfo.introduce,
        imageUrl: myInfo.imageUrl,
        follower: myInfo.follower,
        following: myInfo.following,
        applicants: myInfo.applicants,
        boardLikes: myInfo.boardLikes,
      };
      console.log(userData);
      setUser(userData);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    // user 데이터가 비어있을 때만 API 호출
    if (!user.id) {
      fetchMyInfo();
    }
  }, []);

  const handleTabClick = (tabId) => {
    setActiveTab(tabId);
  };

  return (
    <MyPageSection>
      <Profile user={user} setUser={setUser} />
      <MyPageTab
        activetab={activetab}
        handleTabClick={handleTabClick}
        user={user}
      />
    </MyPageSection>
  );
};

export default MyPage;
