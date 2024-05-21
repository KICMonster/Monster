import React, { useEffect, useState } from 'react';
import ImageClicker from '../main/ImageClicker';
import '../../App.css';
import Mo from "../../img/mo.jpg";
import Ma from "../../img/ma.jpg";
import Sang from "../../img/sang.jpg";
import sicexam from "../../img/sicexam.png"


function Grid() {
  const [cocktails, setCocktails] = useState([]);
  const [randomCocktailImage, setRandomCocktailImage] = useState('');

  const fetchCocktails = () => {
    const dummyData = [
      { id: 1, name: "마티니", ingredients: ["진", "마티니 버무스", "올리브"], image: Ma },
      { id: 2, name: "모히또", ingredients: ["럼", "라임 주스", "민트", "설탕", "탄산수"], image: Mo },
      { id: 3, name: "상그리아", ingredients: ["재료1", "재료2", "재료3"], image: Sang },
      { id: 4, name: "마티니", ingredients: ["진", "마티니 버무스", "올리브"], image: Ma },
      { id: 5, name: "모히또", ingredients: ["럼", "라임 주스", "민트", "설탕", "탄산수"], image: Mo },
      { id: 6, name: "상그리아", ingredients: ["재료1", "재료2", "재료3"], image: Sang },
    ];

    setCocktails(dummyData);
    const randomIndex = Math.floor(Math.random() * dummyData.length);
    setRandomCocktailImage(dummyData[randomIndex].image);
  };

  useEffect(() => {
    fetchCocktails();
  }, []);

  return (
    <div style={{
      margin: '0 10%',
      height: '400px',
      display: 'grid',
      justifyContent: 'start',
      padding: '0 20px 0 0',
      gridGap: '10px',

    }}>
      <div style={{
        gridColumn: '1 / span 3',
        gridRow: '1 / span 2',
      }}>
        <h1>이미지</h1>
        {randomCocktailImage && (
          <img src={randomCocktailImage} style={{ height: '500px' }} alt="Random Cocktail" />
        )}
      </div>

      <div style={{
        gridColumn: '4 / span 5',
        gridRow: '1',
      }}>
        <h1>설명</h1>
        <p className='historyCokatail'>
          칵테일은 술과 여러 종류의 음료, 첨가물 등을 섞어 만든 혼합주를 일컫는다.
          다만, 무알콜 칵테일도 있으며 이들은 목테일(Mocktail, Mock과 Cocktail의 합성어)
          이라고 부른다. 사람의 기호와 취향에 맞추어 독특한 맛과 빛깔을 낼 수 있다.
          명칭의 유래에 대해서는 여러 가지 설이 있지만, 1795년쯤 미국 루이지애나주.
        </p>
      </div>

      <div style={{
        gridColumn: '5 / span 2',
        gridRow: '2',
      }}>
        <h1>조작</h1>
        <ImageClicker />
      </div>

      <div style={{
        gridColumn: '8',
        gridRow: '2',
      }}>
        <h1>컨텐츠</h1>
        <img src={sicexam} style={{ height: '300px' }} />
      </div>

      <div style={{
        gridRow: '3',
      }}>
        <h1>광고</h1>
      </div>
    </div>

  );
}

export default Grid;
