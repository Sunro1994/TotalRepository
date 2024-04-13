// server.js

const express = require('express');
const path = require('path');

const app = express();
const PORT = process.env.PORT || 3000; // 포트 번호 설정

// 정적 파일 제공을 위해 'dist' 디렉터리를 정적 리소스로 지정합니다.
app.use(express.static(path.join(__dirname, 'dist')));

// 라우팅 설정 (전체 페이지를 메인 페이지로 리다이렉션합니다)
app.get('*', (req, res) => {
  res.sendFile(path.join(__dirname, 'dist', 'index.html'));
});

// 서버 시작
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
