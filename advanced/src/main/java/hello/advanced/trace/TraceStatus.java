package hello.advanced.trace;

public class TraceStatus { //로그를 시작할때 상태정보를 가지고 있음
//traceid 내부에 트랜잭션id와 level을 가지고 있다
    //startTimeMs 로그 시작시간이다 로그 종료시 이 시작시간을 기준으로 시작~종료까지 전체 수행시간을 구할 수 있다
    //message 시작시 사용한 메시지이다 이후 로그 종료시에도 이 메시지를 사용해서 출력한다
    //traceid tracestatus를 사용해서 실제로그를 생성하고 처리하는 기능을 개발해보자
    private TraceId traceId;
    private Long startTimeMs;
    private String message;

    public TraceId getTraceId() {
        return traceId;
    }

    public Long getStartTimeMs() {
        return startTimeMs;
    }

    public String getMessage() {
        return message;
    }

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }
}
