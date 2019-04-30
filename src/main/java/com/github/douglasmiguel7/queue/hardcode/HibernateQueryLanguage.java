package com.github.douglasmiguel7.queue.hardcode;

public class HibernateQueryLanguage {

    public static final String SERVICES_AVAILABLE_BY_COMPANY = "select s from Service s inner join s.company c where s.active is true and (s.endAt >= :bookingDate or s.endless is true) and :bookingDate between c.openAt and c.closesAt and c.id = :companyId";

    public static final String SERVICES_AVAILABLE = "select s from Service s inner join s.company c where s.active is true and (s.endAt >= :bookingDate or s.endless is true) and :bookingDate between c.openAt and c.closesAt";

    private HibernateQueryLanguage() {

    }

}
