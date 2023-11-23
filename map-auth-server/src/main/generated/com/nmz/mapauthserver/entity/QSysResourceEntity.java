package com.nmz.mapauthserver.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSysResourceEntity is a Querydsl query type for SysResourceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSysResourceEntity extends EntityPathBase<SysResourceEntity> {

    private static final long serialVersionUID = -1702031270L;

    public static final QSysResourceEntity sysResourceEntity = new QSysResourceEntity("sysResourceEntity");

    public final NumberPath<Integer> resourceId = createNumber("resourceId", Integer.class);

    public final StringPath resourceMethod = createString("resourceMethod");

    public final StringPath resourceName = createString("resourceName");

    public final StringPath resourceUrl = createString("resourceUrl");

    public QSysResourceEntity(String variable) {
        super(SysResourceEntity.class, forVariable(variable));
    }

    public QSysResourceEntity(Path<? extends SysResourceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysResourceEntity(PathMetadata metadata) {
        super(SysResourceEntity.class, metadata);
    }

}

