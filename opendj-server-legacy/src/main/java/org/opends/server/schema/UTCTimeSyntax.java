/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions Copyright [year] [name of copyright owner]".
 *
 * Copyright 2006-2008 Sun Microsystems, Inc.
 * Portions Copyright 2012-2016 ForgeRock AS.
 */
package org.opends.server.schema;

import static org.opends.server.schema.SchemaConstants.*;

import org.forgerock.opendj.ldap.schema.Schema;
import org.forgerock.opendj.ldap.schema.Syntax;
import org.forgerock.opendj.server.config.server.AttributeSyntaxCfg;
import org.opends.server.api.AttributeSyntax;

/**
 * This class implements the UTC time attribute syntax.  This is very similar to
 * the generalized time syntax (and actually has been deprecated in favor of
 * that), but requires that the minute be provided and does not allow for
 * sub-second times.  All matching will be performed using the generalized time
 * matching rules, and equality, ordering, and substring matching will be
 * allowed.
 */
public class UTCTimeSyntax
       extends AttributeSyntax<AttributeSyntaxCfg>
{

  /**
   * Creates a new instance of this syntax.  Note that the only thing that
   * should be done here is to invoke the default constructor for the
   * superclass.  All initialization should be performed in the
   * <CODE>initializeSyntax</CODE> method.
   */
  public UTCTimeSyntax()
  {
    super();
  }

  /** {@inheritDoc} */
  @Override
  public Syntax getSDKSyntax(Schema schema)
  {
    return schema.getSyntax(SchemaConstants.SYNTAX_UTC_TIME_OID);
  }

  /**
   * Retrieves the common name for this attribute syntax.
   *
   * @return  The common name for this attribute syntax.
   */
  @Override
  public String getName()
  {
    return SYNTAX_UTC_TIME_NAME;
  }

  /**
   * Retrieves the OID for this attribute syntax.
   *
   * @return  The OID for this attribute syntax.
   */
  @Override
  public String getOID()
  {
    return SYNTAX_UTC_TIME_OID;
  }

  /**
   * Retrieves a description for this attribute syntax.
   *
   * @return  A description for this attribute syntax.
   */
  @Override
  public String getDescription()
  {
    return SYNTAX_UTC_TIME_DESCRIPTION;
  }
}

