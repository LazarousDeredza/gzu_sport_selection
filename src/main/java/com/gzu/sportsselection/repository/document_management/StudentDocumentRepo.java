//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.repository.document_management;

import com.gzu.sportsselection.model.document_management.StudentDocuments;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDocumentRepo extends JpaRepository<StudentDocuments, Long> {
    @Query(
            value = "select * from tenant_documents where tenant_id=?1",
            nativeQuery = true
    )
    List<StudentDocuments> findLeaseBySearch(@Param("tenantId") String id);
}
