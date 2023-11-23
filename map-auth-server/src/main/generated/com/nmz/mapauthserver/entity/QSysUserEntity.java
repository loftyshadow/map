package com.nmz.mapauthserver.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSysUserEntity is a Querydsl query type for SysUserEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSysUserEntity extends EntityPathBase<SysUserEntity> {

    private static final long serialVersionUID = -430865705L;

    public static final QSysUserEntity sysUserEntity = new QSysUserEntity("sysUserEntity");

    public final DateTimePath<java.sql.Timestamp> creatTime = createDateTime("creatTime", java.sql.Timestamp.class);

    public final BooleanPath delFlag = createBoolean("delFlag");

    public final StringPath email = createString("email");

    public final StringPath password = createString("password");

    public final NumberPath<Integer> phoneNumber = createNumber("phoneNumber", Integer.class);

    public final DateTimePath<java.sql.Timestamp> updateTime = createDateTime("updateTime", java.sql.Timestamp.class);

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public final StringPath userName = createString("userName");

    public QSysUserEntity(String variable) {
        super(SysUserEntity.class, forVariable(variable));
    }

    public QSysUserEntity(Path<? extends SysUserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysUserEntity(PathMetadata metadata) {
        super(SysUserEntity.class, metadata);
    }

}

