import { useState, useEffect } from "react";


function App() {
  const [loading, setLoading] = useState(true);
  const [coins, setCoins] = useState([]); //기본값을 지정하지 않으면 undefined로 인해 length를 구하면서 오류가 생길 수 있다.
  useEffect(()=>{
    fetch('https://api.coinpaprika.com/v1/tickers').then((response)=> response.json()).then((json)=> setCoins(json));
    setLoading(false);
  },[])
 return <div>
    <h1>The Coins! {loading? "" : `(${coins.length})`}</h1>
    {loading ? <strong>Loading...</strong> : <select>
  {coins.map((coin) => 
  <option>
    {coin.name} ({coin.symbol}): {coin.quotes.USD.price} USD
    </option>
    )}
    </select>}
    
 </div>
}

export default App;


//useState가 변할때마다 코드가 새로 실행된다. counter가 변경되었기 떄문
