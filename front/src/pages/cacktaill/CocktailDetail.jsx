import React from 'react';
import { useParams } from 'react-router-dom';
import BasicLayout from "../../layouts/BasicLayout";

const cocktailsData = [
  { id: 1, name: "마티니", ingredients: ["진", "마티니 버무스", "올리브"], image: "martini.jpg", description: "마티니는 진과 마티니 버무스를 섞은 칵테일입니다." },
  { id: 2, name: "모히또", ingredients: ["럼", "라임 주스", "민트", "설탕", "탄산수"], image: "mojito.jpg", description: "모히또는 럼, 라임 주스, 민트, 설탕, 탄산수를 섞은 칵테일입니다." },
  { id: 3, name: "칵테일3", ingredients: ["재료1", "재료2", "재료3"], image: "cocktail3.jpg", description: "칵테일3은 재료1, 재료2, 재료3을 섞은 칵테일입니다." },
  { id: 4, name: "칵테일4", ingredients: ["재료1", "재료2", "재료3"], image: "cocktail4.jpg", description: "칵테일4는 재료1, 재료2, 재료3을 섞은 칵테일입니다." },
  { id: 5, name: "칵테일5", ingredients: ["재료1", "재료2", "재료3"], image: "cocktail5.jpg", description: "칵테일5는 재료1, 재료2, 재료3을 섞은 칵테일입니다." },
];

function CocktailDetail() {
  const { cocktailId } = useParams();
  const cocktail = cocktailsData.find(c => c.id === parseInt(cocktailId));

  if (!cocktail) {
    return <div>칵테일 정보를 찾을 수 없습니다.</div>;
  }

  return (
    <BasicLayout>
      <div style={styles.container}>
        <div style={styles.imageContainer}>
          <img src={cocktail.image} alt={cocktail.name} style={styles.image} />
        </div>
        <div style={styles.infoContainer}>
          <div style={styles.recipe}>
            <h2>{cocktail.name}</h2>
            <p>{cocktail.description}</p> {/* 레시피 설명 추가 */}
          </div>
          <div style={styles.ingredients}>
            <h3>재료</h3>
            <p>{cocktail.ingredients.join(", ")}</p>
          </div>
        </div>
      </div>
    </BasicLayout>
  );
}

const styles = {
  container: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    margin: '20px auto',
    maxWidth: '1200px',
    width: '100%',
  },
  imageContainer: {
    flex: '1',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    padding: '10px',
  },
  image: {
    width: '100%',
    maxWidth: '500px',
    borderRadius: '8px',
  },
  infoContainer: {
    flex: '1',
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'space-between',
    padding: '10px',
  },
  recipe: {
    marginBottom: '20px',
  },
  ingredients: {
    marginTop: '20px',
  }
};

export default CocktailDetail;

CocktailDetail.jsx

