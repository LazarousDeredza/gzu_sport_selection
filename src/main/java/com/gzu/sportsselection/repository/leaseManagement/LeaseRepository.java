//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.repository.leaseManagement;

import com.gzu.sportsselection.model.leaseManagement.Lease;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseRepository extends JpaRepository<Lease, Long> {
    List<Lease> findLeaseByStatus(String status);

    @Query("select s from Lease s where s.timeLeft<=?1 and s.status<>'Terminated' order by s.timeLeft asc ")
    List<Lease> findbyExpirery(int time);

    @Query(
            value = "select p.email,p.phone from tenant p where p.b_email=?1",
            nativeQuery = true
    )
    String findByEmail(String name);

    @Query("Select c from Lease c where lower(c.status) like lower(concat('%', concat(:record, '%'))) or lower(c.id) like lower(concat('%', concat(:record, '%'))) order by c.id asc")
    List<Lease> findLeaseBySearch(@Param("record") String record);

    @Query(
            value = "select file_name from lease_documents  where tenant_id=?1 ",
            nativeQuery = true
    )
    String findTenantForm(String id);

    @Query(
            value = "select * from lease where tenant_id=?1",
            nativeQuery = true
    )
    List<Lease> findTenant(String id);

    @Query(
            value = "select * from lease where tenant_id=?1",
            nativeQuery = true
    )
    Optional<Lease> findTenantid(int id);
}
