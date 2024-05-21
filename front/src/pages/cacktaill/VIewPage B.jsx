import React, { useState, useEffect } from "react";
import BasicLayout from "../../layouts/BasicLayout";

function ViewPage() {
  const [cocktails, setCocktails] = useState([]);

  // 모든 칵테일 값을 불러와서 상태에 설정하는 함수
  const fetchAllCocktails = async () => {
    try {
      // 칵테일 데이터를 가져올 API 엔드포인트 URL 
      const endpoint = 'http://localhost:9092/api/cocktail'; // API 엔드포인트 URL                  
                 
      // fetch를 사용하여 GET 요청을 보냄
      const response = await fetch(endpoint);

      // JSON 형식으로 변환하여 응답 데이터를 가져옴
      const data = await response.json();

      // 응답 데이터를 상태에 설정
      setCocktails(data);
    } catch (error) {
      // 오류가 발생한 경우 오류 메시지 출력
      console.error('Error fetching cocktails:', error);
    }
  };

  useEffect(() => {
    fetchAllCocktails(); // 컴포넌트가 마운트되면 모든 칵테일 데이터를 불러옴
  }, []); // 빈 배열을 전달하여 한 번만 실행되도록 설정

  return (
    <BasicLayout>
      {/* 모든 칵테일 데이터를 가로로 표시 */}
      <div>
        
      </div>
    </BasicLayout>
  );
}

export default ViewPage;
