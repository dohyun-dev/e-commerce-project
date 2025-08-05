import io.hypersistence.utils.hibernate.id.Tsid
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {
    @Id
    @Tsid
    val id: Long? = null

    @CreatedDate
    @Column(updatable = false)
    lateinit var createdAt: LocalDateTime
        protected set

    @LastModifiedDate
    lateinit var modifiedAt: LocalDateTime
        protected set

    @CreatedBy
    @Column(updatable = false)
    var createdBy: Long? = null
        protected set

    @LastModifiedBy
    var modifiedBy: Long? = null
        protected set
}
