package com.example.Demo_spring_boot_project.dtos.book;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@RequiredArgsConstructor
public class BookConfig {
    private final BookServiceImpl bookServiceImpl;

  /*  @Scheduled(initialDelay = 1000,*//*fixedDelay = 1000*//*fixedRate = 1000, timeUnit = TimeUnit.MINUTES)
    public void getTimeEverySecond() {
        System.out.println("Date Every second" + new Date());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }*/

   /* @Scheduled(cron = "0-5 * * * * *")
    public void cronDAteEverySecond() {
        System.out.println("Date Every second" + new Date());
    }*/

  /*  @Scheduled(cron = "1 * * * * *")
    public void deleteElementIsDeletedAtIsNotNull() {
        List<BookDto> all = this.bookServiceImpl.getAll();
        for (BookDto dto : all) {
            if (dto.getDeletedAt() != null) {
                this.bookServiceImpl.deleteById(dto.getId());
                System.out.println("Deleted " + dto);
            }
        }
    }*/
}
