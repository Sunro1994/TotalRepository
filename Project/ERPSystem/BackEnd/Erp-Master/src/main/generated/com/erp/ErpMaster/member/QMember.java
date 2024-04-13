package com.erp.ErpMaster.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1937941139L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Integer> annual_leave_days = createNumber("annual_leave_days", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> birth = createDateTime("birth", java.time.LocalDateTime.class);

    public final com.erp.ErpMaster.depart.QDepartment department;

    public final StringPath email = createString("email");

    public final EnumPath<MemberGender> gender = createEnum("gender", MemberGender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath isDel = createString("isDel");

    public final EnumPath<LeaveEnum> isLeave = createEnum("isLeave", LeaveEnum.class);

    public final DateTimePath<java.time.LocalDateTime> isrtDate = createDateTime("isrtDate", java.time.LocalDateTime.class);

    public final StringPath isUsed = createString("isUsed");

    public final StringPath loginId = createString("loginId");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath pnum = createString("pnum");

    public final EnumPath<com.erp.ErpMaster.rank.RankEnum> rank = createEnum("rank", com.erp.ErpMaster.rank.RankEnum.class);

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public final DateTimePath<java.time.LocalDateTime> updtDate = createDateTime("updtDate", java.time.LocalDateTime.class);

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new com.erp.ErpMaster.depart.QDepartment(forProperty("department"), inits.get("department")) : null;
    }

}

