import { createBrowserRouter } from 'react-router-dom';
import Home from '../pages/Home';
import LoginPage from '../pages/LoginPage';
import LoginRouter from './LoginRouter';
import Mypage from '../pages/Mypage';
import JoinRouter from './JoinRouter';

import AdditionalForm from '../component/login/AdditionalForm';
import { Suspense } from 'react';
import ViewPage from '../pages/cacktaill/VIewPage';
import IngredientPage from '../pages/cacktaill/IngredientPage';
import IndexPage from '../pages/todo/IndexPage';
import CocktailDetail from '../pages/cacktaill/CocktailDetail';
import CraftPage from '../pages/information/CraftPage';
import HistoryPage from '../pages/information/HistoryPage';
import Join from '../component/login/Join';
import TrendNews from '../pages/information/TrendNews';
import AnalysisComplete from '../pages/AnalysisComplete';
import Weather from '../component/main/wheather';
import TasteAnalysis from '../component/detail/tasteAnalysis';


const Loading = <div className={'bg-red-800'}>Loading...</div>
const root = createBrowserRouter([
  {
    path: '',
    element: <Suspense fallback={Loading}><Home /></Suspense>         //메인화면
  },
  {
    path: '/login',
    element: <Suspense fallback={Loading}><LoginPage /></Suspense>,
    children: LoginRouter() // LoginRouter()가 객체를 반환하므로 이를 바로 사용     //로그인
  },
  {
    path: '/join',
    element: <Suspense fallback={Loading}><Join />,</Suspense>,             //회원가입 이멜인증
    children: JoinRouter()
  },
  {
    path: '/additional',
    element: <Suspense fallback={Loading}><AdditionalForm /></Suspense>           //회원가입   
  },
  {
    path: '/mypage',
    element: <Suspense fallback={Loading}><Mypage /></Suspense>                   //프로필
  },
  {
    path: '/ViewPage',
    element: <Suspense fallback={Loading}><ViewPage /></Suspense>                  // 칵테일 리스트
  },
  {
    path: '/cocktail/:cocktailId',                                      
    element: <Suspense fallback={Loading}><CocktailDetail /></Suspense> // 칵테일 상세 페이지
  },
  {
    path: '/cocktail/martini',
    element: <Suspense fallback={Loading}><CocktailDetail /></Suspense> // 칵테일 상세페이지(더미 데이터)
  },
  {
    path: '/Ingredient',
    element: <Suspense fallback={Loading}><IngredientPage /></Suspense>             //재료리스트
  },
  {
    path: '/TodayCocktail',
    element: <Suspense fallback={Loading}><IndexPage /></Suspense>                  //추천칵테일
  },
  {
    path: '/history',
    element: <Suspense fallback={Loading}><HistoryPage /></Suspense>                //역사 페이지
  },
  {
    path: '/craft/:key',
    element: <Suspense fallback={Loading} ><CraftPage /></Suspense>                     //기초제조법페이지
  },
  {
    path: '/taste', // 기호조사. 필요 페이지와 연결할것.지금은 home.jsx에 버튼. 회원가입 페이지와 연결할 경우 로직 수정할 필요.   
    element: <TasteAnalysis />, // 회원가입 로직과 연결 할 시 프론트 경로작업&비동기 통신전달값 추가 후 백엔드에 문의
    children: [
      {
        path: 'complete', // '/taste'의 하위 경로로 'complete'를 정의
        element: <AnalysisComplete /> // '/taste/complete'에 해당하는 컴포넌트
      }
    ]
  },
  {
    path: '/trendNews',       // 뉴스 경로. 조정 필요. 
    element: <TrendNews />
  },
  {
    path: '/weather',
    element: <Weather />
  },
]);

export default root;