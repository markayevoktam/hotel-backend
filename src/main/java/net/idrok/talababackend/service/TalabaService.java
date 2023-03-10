package net.idrok.talababackend.service;

import net.idrok.talababackend.entity.Talaba;
import net.idrok.talababackend.repository.TalabaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TalabaService implements Talabatimp {


    @Autowired
    TalabaRepository tsr;

    public Page<Talaba> getAll(String key, Pageable pageable) {
        return tsr.findByOnlyKey(key, pageable);
    }

    public Talaba getById(Long id) {
        return tsr.findById(id).get();
    }

       @Override
    public Page<Talaba> getAll(Pageable pageable) {
        return tsr.findAll(pageable);
    }

    public Talaba create(Talaba talaba) {
        if (talaba.getId() == null) {
            return tsr.save(talaba);
        }
        throw new RuntimeException("Id Null bo'lishi shart");
    }

    public Talaba update(Talaba talaba) {
        if (talaba.getId() != null) {
            return tsr.save(talaba);
        }
        throw new RuntimeException("Id  bo'lishi shart");
    }

    public void delete(Talaba talaba) {
        tsr.delete(talaba);

    }

    public void deleteById(Long id) {
        tsr.deleteById(id);
    }


    @Override
    public Page<Talaba> getAllByFamilyaContainsIgnoreCaseOrIsmContainsIgnoreCaseOrSharifContainsIgnoreCaseOrHududContainsIgnoreCaseOrId(String key1, Pageable pageable) {
        try {
            Long n = Long.parseLong(key1);
            int i = Integer.parseInt(key1);
            return tsr.findAllByFamilyaContainsIgnoreCaseOrIsmContainsIgnoreCaseOrSharifContainsIgnoreCaseOrHududContainsIgnoreCaseOrId(key1, key1, key1, key1, n, pageable);
        } catch (Exception b) {
            return tsr.findAllByFamilyaContainsIgnoreCaseOrIsmContainsIgnoreCaseOrSharifContainsIgnoreCaseOrHududContainsIgnoreCaseOrId(key1, key1, key1, key1, (long) -1, pageable);


        }
    }

    @Override
    public Page<Talaba> getAllByTalented(Boolean b, Pageable pageable) {
        return tsr.findAllByTalented(b, pageable);
    }

    public Page<Talaba> getAllByFilter(String key, Long fakultetId, Long yunalishId, Long guruhId, Pageable pageable) {
         
            return tsr.findByOnlyKey(key.toUpperCase(), pageable);
        
    }
}
