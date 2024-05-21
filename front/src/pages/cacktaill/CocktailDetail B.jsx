import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import BasicLayout from '../../layouts/BasicLayout';

function CocktailDetail({ ...dummyData }) {
    const { key } = useParams(); // URL 매개변수 가져오기
    const [detail, setDetail] = useState(null);

    // 특정 칵테일의 상세 정보를 불러오는 함수
    const fetchCocktailDetail = async () => {
        try {
            const endpoint = `http://localhost:9092/api/cocktail/${key}`; // 특정 칵테일 엔드포인트
            const response = await fetch(endpoint);
            const data = await response.json();
            setDetail(data);
        } catch (error) {
            console.error('Error fetching cocktail detail:', error);
        }
    };

    useEffect(() => {
        fetchCocktailDetail(); // 컴포넌트가 마운트되면 상세 정보를 불러옴
    }, [key]); // key 값이 변경될 때마다 데이터를 다시 불러옴


    return (
        <BasicLayout>
            <div className="Cocktail">
                <h1>{detail.name}</h1>
                <img src={detail.image} alt={detail.name} style={{ width: "300px", borderRadius: "8px" }} />
                <p>재료: {detail.ingredients.join(", ")}</p>
                <p>설명: {detail.description}</p> {/* 칵테일 설명 추가 */}
            </div>
        </BasicLayout>
    );
}

export default CocktailDetail;