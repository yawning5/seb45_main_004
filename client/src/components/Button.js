import { styled } from 'styled-components';
import PropTypes from 'prop-types';

const StyleButton = styled.button`
  /* 버튼 기본 스타일*/
  /* width: 100px; */
  width: 120px;
  height: 42px;
  /* border-radius: 10px; */
  border-radius: 20px;
  font-size: 1rem;
  cursor: pointer;
  border: 1px solid;
  /* 버튼 조건부 스타일 &.{btnType} 
  예) 카테고리 버튼 : &.Button-category
  */

  &.Button-membership:active {
    transform: translateY(1px); // 클릭 시 버튼을 아래로 2px 이동
    box-shadow: inset 1px 1px 1px rgb(0, 0, 0, 0.7);
  }

  &.Button-login {
    width: 430px;
    height: 60px;
    border: 0;
    color: white;
    font-weight: 600;
    background-color: rgb(10, 149, 255);
    margin-bottom: 10px;
  }

  &.Button-based {
    width: 110px;
    height: 42px;
    font-weight: 700;
    padding: 2px 10px;
    margin-left: 20px;
    background-color: rgba(246, 246, 246, 0);
  }

  &.Button-notification {
    width: 42px;
    background-color: rgba(246, 246, 246, 0);
    border: 0;
    font-size: 42px;
    text-align: center;
    padding: 0;
    margin-left: 20px;
  }

  &.Button-like {
    width: 180px;
    height: 60px;
    background-color: #ff6ac6;
    border: none;
    border-radius: 20px;
    cursor: pointer;
    padding: 0px;
    margin-left: 30px;
    margin-right: 30px;
    color: white;
    font-size: 1.2rem;
  }
  &.Button-participations {
    width: 180px;
    height: 60px;
    background-color: #ffa472;
    border: none;
    border-radius: 20px;
    cursor: pointer;
    padding: 0px;
    margin-left: 30px;
    margin-right: 30px;
    color: white;
    font-size: 1.2rem;
  }

  &.Button-text {
    background-color: rgba(246, 246, 246, 0);
    border: none;
    color: ${(props) => (props ? props.color : 'default')};
    border-radius: 0;
    font-weight: 600;
    font-size: 1.2rem;
    text-align: right;
    position: absolute;
    bottom: 1px;
    right: 10px;
    cursor: pointer;
  }
`;

const Button = ({ type, text, onClick }) => {
  const btnType = [
    'based',
    'newCard',
    'notification',
    'like',
    'participations',
    'login',
    'text',
  ].includes(type)
    ? type
    : 'default';

  return (
    <StyleButton className={`Button-${btnType}`} onClick={onClick}>
      {text}
    </StyleButton>
  );
};

Button.defaultProps = {
  type: 'default',
};

Button.propTypes = {
  type: PropTypes.string.isRequired,
  text: PropTypes.object.isRequired,
  onClick: PropTypes.func.isRequired,
};

export default Button;
