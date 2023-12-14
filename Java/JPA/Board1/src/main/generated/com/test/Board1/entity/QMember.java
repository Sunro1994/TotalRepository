package com.test.Board1.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1777567151L;

    public static final QMember member = new QMember("member1");

    public final com.test.Board1.entity.baseEntity.QBaseEntity _super = new com.test.Board1.entity.baseEntity.QBaseEntity(this);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modfied_date = _super.modfied_date;

    //inherited
    public final StringPath modifier = _super.modifier;

    public final StringPath userId = createString("userId");

    public final StringPath userPw = createString("userPw");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> wdate = _super.wdate;

    //inherited
    public final StringPath writer = _super.writer;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

