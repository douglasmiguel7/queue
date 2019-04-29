package com.github.douglasmiguel7.queue.hardcode;

public class Queries {

    private Queries() {

    }

    public static final String SERVICES_AVAILABLE = "select service.* from queue.service service inner join queue.company company on company.id = service.company_id where date_trunc('minute', service.end_at) >= date_trunc('minute', :bookingDate)";
}
