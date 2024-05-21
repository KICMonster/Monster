import BasicLayout from '../layouts/BasicLayout';
import "../layouts/BasicLayout.css"
import ImageClicker from '../component/main/ImageClicker';
import InteractiveImage from '../component/main/InteractiveImage';
import CocktailLink from '../component/main/CocktailLink';
import Grid from '../component/main/Grid';
import sicexam from '../img/sicexam.png';
import MapContainer from '../component/detail/MapContainer';


function Home({dummyData}) {

  return (
    <BasicLayout >
      <Grid />

      {/* <ImageClicker /> */}
      {/* <InteractiveImage /> */}

      {/* <CocktailLink /> */}

    </BasicLayout>
  );
}
export default Home;