package com.eazybytes.constants;

//실제 배포시에는 이를 운영팀에 얘기하여 런타임중 삽입할 수 있도록 한다.
//또는 CI/CD중 Jenkins같은 기술을 사용하여 런타임중 환경변수로 설정 할 수 있도록 한다.
public interface SecurityConstants {

    public static final String JWT_KEY = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";
    public static final String JWT_HEADER = "Authorization";

}