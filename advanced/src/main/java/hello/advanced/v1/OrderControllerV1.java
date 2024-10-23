package hello.advanced.v1;


import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller+@ResponseBody
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderServiceV0;
    private final HelloTraceV1 trace;


    @GetMapping("/v1/request")
    public String request(String ItemId) {

        TraceStatus sta = trace.begin("OrderController.request()");
        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request(")
            orderServiceV0.orderItem(ItemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
        throw e;
        }
    }

}
