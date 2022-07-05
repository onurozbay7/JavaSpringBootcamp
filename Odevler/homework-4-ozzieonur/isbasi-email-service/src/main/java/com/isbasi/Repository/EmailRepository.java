package com.isbasi.Repository;

import com.isbasi.dto.EmailDto;
import com.isbasi.model.Email;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailRepository extends MongoRepository<EmailDto, Integer> { // MongoDB Veritabanı için MongoRepository Kullanıldı.
}
