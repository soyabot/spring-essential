package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static jdk.internal.net.http.common.MinimalFuture.complete;
import static org.apache.naming.SelectorContext.prefix;


@Slf4j
@Component
public class HelloTraceV1 {

    private static final String START_PREFIX="---->";
    private static final String COMPLEX_PREFIX="<---";
    private static final String EX_PREFIX="<X-";
    public TraceStatus begin(String message){
        TraceId traceId = new TraceId();
        Long startTimeMs = System.currentTimeMillis();

//        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel().message);
        //로그출력
        return new TraceStatus(traceId,startTimeMs, message);
    }




    //level=0ㄴ
    //level=2   |--->

    //level=2 ex  |    |<x-
    //level=1 ex  <x
    private String addSpace(String startPrefix, int level) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<level; i++){
            sb.append((i ==level - 1)?"|" + prefix :"|   ");
        }
            return sb.toString();
    }

    public void exception(TraceStatus status, IllegalAccessException e) {
    }


   public void end(TraceStatus status){
        complete(status, null);
    }

    private void complete(TraceStatus status, Object o) {
    }
   /* public void exception(TraceStatus status, Exception e){

    } */....*/



    //HelloTraceV1을 사용해서 실제로그를 시작하고 종료할 수 있다 로그를 출력하고 실행시간도 측정할 수 잇다
    //@Componet싱글톤으로 사용하기 위해 스프링 빈으로 등록한다 컴포넌트 스캔대상이 된다

   /* begin(..)
    end(..)
    exception(..)
    로그추적기에서 사용되는 공개메서드는 다음 3가지이다
    'TraceStatus begin(String message)
    로그를 시작한다
    로그메시지를 파라미터로 받아서 시작로그를 출력산다
    응답결과로 현재 로그상태인 TraceStatus를 반환하다
    void end(TraceStatus status
    로그를 정상 종료한다
    파라미터로 시작로그의 상태 tracestatus를 전달 받는다
    실행시간을 계산 종료시에도 시작할때와 동일한 로그메시지를 출력
    정상 흐름에서 호출
    void exception(TraceStatus status, Exception e)
    로그를 예외상황으로 종료한다
    TraceStatus, Exception정보를 전달받아서 예외정보를 포함한 로그를 출력한다



    */



}
