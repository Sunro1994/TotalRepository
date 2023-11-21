import { useState, useEffect } from "react";
import Movie from "../components/Movie.js";

function Home(){
    const [loading, setLoading] = useState(true);
    const [movies , setMovies] = useState([]);
    const getMovies = async() => {
      const json = await ( 
        await fetch(
          `https://yts.mx/api/v2/list_movies.json?minimum_rating=8.8&sort_by=year`
          )
          ).json();
      // const json = await ( (await fetch(`https://yts.mx/api/v2/list_movies.json?minimum_rating=8.8&sort_by=year`)).json(); 이렇게 짧게도 가능하다. await알아보기
      setMovies(json.data.movies);
      setLoading(false);
    }
    useEffect(()=>{
      getMovies()
    },[])
    console.log(movies)
 return<div>
    {loading ? <h1>Loading...</h1> : <div>{movies.map((movie)=> (
    <Movie 
    id= {movie.id}
    key={movie.id}
    coverImg={movie.medium_cover_image}
    title={movie.title}
    summary={movie.summary}
    genre={movie.genres}
    />
    ))}</div>}
 </div>
}

export default Home;