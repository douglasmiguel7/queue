package com.github.douglasmiguel7.queue.validator;

import com.github.douglasmiguel7.queue.input.BookingInput;
import com.github.douglasmiguel7.queue.repository.ServiceRepository;
import com.github.douglasmiguel7.queue.utils.Formatters;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

@Component
public class BookingValidator implements ConstraintValidator<ValidateBooking, BookingInput> {

    private final ServiceRepository serviceRepository;

    @Autowired
    public BookingValidator(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void initialize(ValidateBooking constraintAnnotation) {

    }

    @Override
    public boolean isValid(BookingInput bookingInput, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();

        Date date = bookingInput.getDate();
        Long serviceId = bookingInput.getServiceId();

        if (date == null) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("date can't be null").addPropertyNode("date").addConstraintViolation();
            return false;
        }

        if (serviceId == null) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("serviceId can't be null").addPropertyNode("serviceId").addConstraintViolation();
            return false;
        }

        DateTime dateTime = new DateTime(date);

        if (dateTime.isBeforeNow()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("date can not be in the past").addPropertyNode("date").addConstraintViolation();
            return false;
        }

        if (!serviceRepository.isAvailableByIdAndDate(serviceId, date)) {
            constraintValidatorContext.buildConstraintViolationWithTemplate(StringUtils.join("service unavailable at ", Formatters.toTime(date))).addPropertyNode("").addConstraintViolation();
            return false;
        }

        return true;
    }
}
