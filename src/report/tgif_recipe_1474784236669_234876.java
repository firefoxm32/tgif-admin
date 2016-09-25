/*
 * Generated by JasperReports - 9/25/16 1:17 PM
 */
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.fill.*;

import java.util.*;
import java.math.*;
import java.text.*;
import java.io.*;
import java.net.*;

import net.sf.jasperreports.engine.*;
import java.util.*;
import net.sf.jasperreports.engine.data.*;


/**
 *
 */
public class tgif_recipe_1474784236669_234876 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_transaction_id = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_REPORT_TIME_ZONE = null;
    private JRFillParameter parameter_REPORT_TEMPLATES = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_REPORT_FILE_RESOLVER = null;
    private JRFillParameter parameter_REPORT_FORMAT_FACTORY = null;
    private JRFillParameter parameter_REPORT_PARAMETERS_MAP = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_URL_HANDLER_FACTORY = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillField field_p = null;
    private JRFillField field_tDate = null;
    private JRFillField field_amount = null;
    private JRFillField field_qty = null;
    private JRFillField field_tNum = null;
    private JRFillField field_name = null;
    private JRFillField field_tId = null;
    private JRFillField field_cId = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_sub_total = null;
    private JRFillVariable variable_formatter_sub = null;
    private JRFillVariable variable_or_no = null;
    private JRFillVariable variable_now = null;
    private JRFillVariable variable_service_charge = null;
    private JRFillVariable variable_senior_citizen = null;
    private JRFillVariable variable_member = null;
    private JRFillVariable variable_current_day = null;
    private JRFillVariable variable_change = null;
    private JRFillVariable variable_total = null;
    private JRFillVariable variable_sub_total1 = null;
    private JRFillVariable variable_amt = null;


    /**
     *
     */
    public void customizedInit(
        Map pm,
        Map fm,
        Map vm
        )
    {
        initParams(pm);
        initFields(fm);
        initVars(vm);
    }


    /**
     *
     */
    private void initParams(Map pm)
    {
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_transaction_id = (JRFillParameter)pm.get("transaction_id");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_REPORT_LOCALE = (JRFillParameter)pm.get("REPORT_LOCALE");
        parameter_REPORT_TIME_ZONE = (JRFillParameter)pm.get("REPORT_TIME_ZONE");
        parameter_REPORT_TEMPLATES = (JRFillParameter)pm.get("REPORT_TEMPLATES");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_REPORT_FILE_RESOLVER = (JRFillParameter)pm.get("REPORT_FILE_RESOLVER");
        parameter_REPORT_FORMAT_FACTORY = (JRFillParameter)pm.get("REPORT_FORMAT_FACTORY");
        parameter_REPORT_PARAMETERS_MAP = (JRFillParameter)pm.get("REPORT_PARAMETERS_MAP");
        parameter_REPORT_RESOURCE_BUNDLE = (JRFillParameter)pm.get("REPORT_RESOURCE_BUNDLE");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_URL_HANDLER_FACTORY = (JRFillParameter)pm.get("REPORT_URL_HANDLER_FACTORY");
        parameter_REPORT_VIRTUALIZER = (JRFillParameter)pm.get("REPORT_VIRTUALIZER");
    }


    /**
     *
     */
    private void initFields(Map fm)
    {
        field_p = (JRFillField)fm.get("p");
        field_tDate = (JRFillField)fm.get("tDate");
        field_amount = (JRFillField)fm.get("amount");
        field_qty = (JRFillField)fm.get("qty");
        field_tNum = (JRFillField)fm.get("tNum");
        field_name = (JRFillField)fm.get("name");
        field_tId = (JRFillField)fm.get("tId");
        field_cId = (JRFillField)fm.get("cId");
    }


    /**
     *
     */
    private void initVars(Map vm)
    {
        variable_PAGE_NUMBER = (JRFillVariable)vm.get("PAGE_NUMBER");
        variable_COLUMN_NUMBER = (JRFillVariable)vm.get("COLUMN_NUMBER");
        variable_REPORT_COUNT = (JRFillVariable)vm.get("REPORT_COUNT");
        variable_PAGE_COUNT = (JRFillVariable)vm.get("PAGE_COUNT");
        variable_COLUMN_COUNT = (JRFillVariable)vm.get("COLUMN_COUNT");
        variable_sub_total = (JRFillVariable)vm.get("sub_total");
        variable_formatter_sub = (JRFillVariable)vm.get("formatter_sub");
        variable_or_no = (JRFillVariable)vm.get("or_no");
        variable_now = (JRFillVariable)vm.get("now");
        variable_service_charge = (JRFillVariable)vm.get("service_charge");
        variable_senior_citizen = (JRFillVariable)vm.get("senior_citizen");
        variable_member = (JRFillVariable)vm.get("member");
        variable_current_day = (JRFillVariable)vm.get("current_day");
        variable_change = (JRFillVariable)vm.get("change");
        variable_total = (JRFillVariable)vm.get("total");
        variable_sub_total1 = (JRFillVariable)vm.get("sub_total1");
        variable_amt = (JRFillVariable)vm.get("amt");
    }


    /**
     *
     */
    public Object evaluate(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.Double)(new Double(  (((java.lang.Double)field_p.getValue()).doubleValue()) *(((java.lang.Integer)field_qty.getValue()).intValue()) ));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.lang.String)(new java.text.DecimalFormat("#,##0.00").format( new java.lang.Double(((java.lang.Double)variable_sub_total.getValue()).doubleValue())));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.String)(new java.text.DecimalFormat("#,##0.00").format(0.00));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.lang.String)("0000000000000000001");//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.lang.String)(new SimpleDateFormat("MM/dd/yy HH:mm a").format(new Date()));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.String)(new SimpleDateFormat("M/dd/yy HH:mm a").format(new Date()));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.07 * ((((java.lang.Double)field_p.getValue()).doubleValue()) * (((java.lang.Integer)field_qty.getValue()).doubleValue()))));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.lang.Double)(new java.lang.Double(  ((((java.lang.Double)variable_sub_total.getValue()).doubleValue()) *(0.20)) * -1 ));//$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = (java.lang.Double)(new java.lang.Double( 0.00));//$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = (java.lang.Double)(((java.lang.String)variable_current_day.getValue()) == "Monday" ?//$JR_EXPR_ID=19$
new java.lang.Double(  ((((java.lang.Double)variable_sub_total.getValue()).doubleValue()) *(0.30)) * -1 )//$JR_EXPR_ID=19$
://$JR_EXPR_ID=19$
new java.lang.Double(  ((((java.lang.Double)variable_sub_total.getValue()).doubleValue()) *(0.20)) * -1 ));//$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = (java.lang.String)(new SimpleDateFormat("EEEE").format(new Date()));//$JR_EXPR_ID=21$
                break;
            }
            case 22 : 
            {
                value = (java.lang.Double)(new java.lang.Double((((java.lang.Double)field_amount.getValue()).doubleValue() - ((java.lang.Double)variable_total.getValue()).doubleValue()) * -1 ));//$JR_EXPR_ID=22$
                break;
            }
            case 23 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=23$
                break;
            }
            case 24 : 
            {
                value = (java.lang.Double)(new java.lang.Double( ((java.lang.Double)variable_sub_total.getValue()).doubleValue() + (((java.lang.Double)variable_senior_citizen.getValue()).doubleValue() +((java.lang.Double)variable_member.getValue()).doubleValue()) ));//$JR_EXPR_ID=24$
                break;
            }
            case 25 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=25$
                break;
            }
            case 26 : 
            {
                value = (java.lang.Double)(new java.lang.Double(  (((java.lang.Double)variable_sub_total.getValue()).doubleValue()) +(((java.lang.Double)variable_service_charge.getValue()).doubleValue()) ));//$JR_EXPR_ID=26$
                break;
            }
            case 27 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=27$
                break;
            }
            case 28 : 
            {
                value = (java.lang.Double)(new Double(  (((java.lang.Double)field_p.getValue()).doubleValue()) *(((java.lang.Integer)field_qty.getValue()).intValue()) ));//$JR_EXPR_ID=28$
                break;
            }
            case 29 : 
            {
                value = (java.lang.String)(((java.lang.String)field_tId.getValue()));//$JR_EXPR_ID=29$
                break;
            }
            case 30 : 
            {
                value = (java.lang.String)(((java.lang.String)variable_or_no.getValue()));//$JR_EXPR_ID=30$
                break;
            }
            case 31 : 
            {
                value = (java.sql.Timestamp)(((java.sql.Timestamp)field_tDate.getValue()));//$JR_EXPR_ID=31$
                break;
            }
            case 32 : 
            {
                value = (java.lang.String)(((java.lang.String)variable_now.getValue()));//$JR_EXPR_ID=32$
                break;
            }
            case 33 : 
            {
                value = (java.lang.Integer)(((java.lang.Integer)field_tNum.getValue()));//$JR_EXPR_ID=33$
                break;
            }
            case 34 : 
            {
                value = (java.lang.String)(((java.lang.String)field_cId.getValue()));//$JR_EXPR_ID=34$
                break;
            }
            case 35 : 
            {
                value = (java.lang.Integer)(((java.lang.Integer)field_qty.getValue()));//$JR_EXPR_ID=35$
                break;
            }
            case 36 : 
            {
                value = (java.lang.Double)(((java.lang.Double)field_p.getValue()));//$JR_EXPR_ID=36$
                break;
            }
            case 37 : 
            {
                value = (java.lang.String)(((java.lang.String)field_name.getValue()));//$JR_EXPR_ID=37$
                break;
            }
            case 38 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_amt.getValue()));//$JR_EXPR_ID=38$
                break;
            }
            case 39 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_sub_total1.getValue()));//$JR_EXPR_ID=39$
                break;
            }
            case 40 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_service_charge.getValue()));//$JR_EXPR_ID=40$
                break;
            }
            case 41 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_senior_citizen.getValue()));//$JR_EXPR_ID=41$
                break;
            }
            case 42 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_member.getValue()));//$JR_EXPR_ID=42$
                break;
            }
            case 43 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_total.getValue()));//$JR_EXPR_ID=43$
                break;
            }
            case 44 : 
            {
                value = (java.lang.Double)(new java.lang.Double(  (((java.lang.Double)field_amount.getValue()).doubleValue()) * -1 ));//$JR_EXPR_ID=44$
                break;
            }
            case 45 : 
            {
                value = (java.lang.Double)(new java.lang.Double(  (((java.lang.Double)variable_total.getValue()).doubleValue()) -(((java.lang.Double)field_amount.getValue()).doubleValue()) ));//$JR_EXPR_ID=45$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateOld(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.Double)(new Double(  (((java.lang.Double)field_p.getOldValue()).doubleValue()) *(((java.lang.Integer)field_qty.getOldValue()).intValue()) ));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.lang.String)(new java.text.DecimalFormat("#,##0.00").format( new java.lang.Double(((java.lang.Double)variable_sub_total.getOldValue()).doubleValue())));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.String)(new java.text.DecimalFormat("#,##0.00").format(0.00));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.lang.String)("0000000000000000001");//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.lang.String)(new SimpleDateFormat("MM/dd/yy HH:mm a").format(new Date()));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.String)(new SimpleDateFormat("M/dd/yy HH:mm a").format(new Date()));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.07 * ((((java.lang.Double)field_p.getOldValue()).doubleValue()) * (((java.lang.Integer)field_qty.getOldValue()).doubleValue()))));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.lang.Double)(new java.lang.Double(  ((((java.lang.Double)variable_sub_total.getOldValue()).doubleValue()) *(0.20)) * -1 ));//$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = (java.lang.Double)(new java.lang.Double( 0.00));//$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = (java.lang.Double)(((java.lang.String)variable_current_day.getOldValue()) == "Monday" ?//$JR_EXPR_ID=19$
new java.lang.Double(  ((((java.lang.Double)variable_sub_total.getOldValue()).doubleValue()) *(0.30)) * -1 )//$JR_EXPR_ID=19$
://$JR_EXPR_ID=19$
new java.lang.Double(  ((((java.lang.Double)variable_sub_total.getOldValue()).doubleValue()) *(0.20)) * -1 ));//$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = (java.lang.String)(new SimpleDateFormat("EEEE").format(new Date()));//$JR_EXPR_ID=21$
                break;
            }
            case 22 : 
            {
                value = (java.lang.Double)(new java.lang.Double((((java.lang.Double)field_amount.getOldValue()).doubleValue() - ((java.lang.Double)variable_total.getOldValue()).doubleValue()) * -1 ));//$JR_EXPR_ID=22$
                break;
            }
            case 23 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=23$
                break;
            }
            case 24 : 
            {
                value = (java.lang.Double)(new java.lang.Double( ((java.lang.Double)variable_sub_total.getOldValue()).doubleValue() + (((java.lang.Double)variable_senior_citizen.getOldValue()).doubleValue() +((java.lang.Double)variable_member.getOldValue()).doubleValue()) ));//$JR_EXPR_ID=24$
                break;
            }
            case 25 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=25$
                break;
            }
            case 26 : 
            {
                value = (java.lang.Double)(new java.lang.Double(  (((java.lang.Double)variable_sub_total.getOldValue()).doubleValue()) +(((java.lang.Double)variable_service_charge.getOldValue()).doubleValue()) ));//$JR_EXPR_ID=26$
                break;
            }
            case 27 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=27$
                break;
            }
            case 28 : 
            {
                value = (java.lang.Double)(new Double(  (((java.lang.Double)field_p.getOldValue()).doubleValue()) *(((java.lang.Integer)field_qty.getOldValue()).intValue()) ));//$JR_EXPR_ID=28$
                break;
            }
            case 29 : 
            {
                value = (java.lang.String)(((java.lang.String)field_tId.getOldValue()));//$JR_EXPR_ID=29$
                break;
            }
            case 30 : 
            {
                value = (java.lang.String)(((java.lang.String)variable_or_no.getOldValue()));//$JR_EXPR_ID=30$
                break;
            }
            case 31 : 
            {
                value = (java.sql.Timestamp)(((java.sql.Timestamp)field_tDate.getOldValue()));//$JR_EXPR_ID=31$
                break;
            }
            case 32 : 
            {
                value = (java.lang.String)(((java.lang.String)variable_now.getOldValue()));//$JR_EXPR_ID=32$
                break;
            }
            case 33 : 
            {
                value = (java.lang.Integer)(((java.lang.Integer)field_tNum.getOldValue()));//$JR_EXPR_ID=33$
                break;
            }
            case 34 : 
            {
                value = (java.lang.String)(((java.lang.String)field_cId.getOldValue()));//$JR_EXPR_ID=34$
                break;
            }
            case 35 : 
            {
                value = (java.lang.Integer)(((java.lang.Integer)field_qty.getOldValue()));//$JR_EXPR_ID=35$
                break;
            }
            case 36 : 
            {
                value = (java.lang.Double)(((java.lang.Double)field_p.getOldValue()));//$JR_EXPR_ID=36$
                break;
            }
            case 37 : 
            {
                value = (java.lang.String)(((java.lang.String)field_name.getOldValue()));//$JR_EXPR_ID=37$
                break;
            }
            case 38 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_amt.getOldValue()));//$JR_EXPR_ID=38$
                break;
            }
            case 39 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_sub_total1.getOldValue()));//$JR_EXPR_ID=39$
                break;
            }
            case 40 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_service_charge.getOldValue()));//$JR_EXPR_ID=40$
                break;
            }
            case 41 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_senior_citizen.getOldValue()));//$JR_EXPR_ID=41$
                break;
            }
            case 42 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_member.getOldValue()));//$JR_EXPR_ID=42$
                break;
            }
            case 43 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_total.getOldValue()));//$JR_EXPR_ID=43$
                break;
            }
            case 44 : 
            {
                value = (java.lang.Double)(new java.lang.Double(  (((java.lang.Double)field_amount.getOldValue()).doubleValue()) * -1 ));//$JR_EXPR_ID=44$
                break;
            }
            case 45 : 
            {
                value = (java.lang.Double)(new java.lang.Double(  (((java.lang.Double)variable_total.getOldValue()).doubleValue()) -(((java.lang.Double)field_amount.getOldValue()).doubleValue()) ));//$JR_EXPR_ID=45$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateEstimated(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.Double)(new Double(  (((java.lang.Double)field_p.getValue()).doubleValue()) *(((java.lang.Integer)field_qty.getValue()).intValue()) ));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.lang.String)(new java.text.DecimalFormat("#,##0.00").format( new java.lang.Double(((java.lang.Double)variable_sub_total.getEstimatedValue()).doubleValue())));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.String)(new java.text.DecimalFormat("#,##0.00").format(0.00));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.lang.String)("0000000000000000001");//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.lang.String)(new SimpleDateFormat("MM/dd/yy HH:mm a").format(new Date()));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.String)(new SimpleDateFormat("M/dd/yy HH:mm a").format(new Date()));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.07 * ((((java.lang.Double)field_p.getValue()).doubleValue()) * (((java.lang.Integer)field_qty.getValue()).doubleValue()))));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=16$
                break;
            }
            case 17 : 
            {
                value = (java.lang.Double)(new java.lang.Double(  ((((java.lang.Double)variable_sub_total.getEstimatedValue()).doubleValue()) *(0.20)) * -1 ));//$JR_EXPR_ID=17$
                break;
            }
            case 18 : 
            {
                value = (java.lang.Double)(new java.lang.Double( 0.00));//$JR_EXPR_ID=18$
                break;
            }
            case 19 : 
            {
                value = (java.lang.Double)(((java.lang.String)variable_current_day.getEstimatedValue()) == "Monday" ?//$JR_EXPR_ID=19$
new java.lang.Double(  ((((java.lang.Double)variable_sub_total.getEstimatedValue()).doubleValue()) *(0.30)) * -1 )//$JR_EXPR_ID=19$
://$JR_EXPR_ID=19$
new java.lang.Double(  ((((java.lang.Double)variable_sub_total.getEstimatedValue()).doubleValue()) *(0.20)) * -1 ));//$JR_EXPR_ID=19$
                break;
            }
            case 20 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=20$
                break;
            }
            case 21 : 
            {
                value = (java.lang.String)(new SimpleDateFormat("EEEE").format(new Date()));//$JR_EXPR_ID=21$
                break;
            }
            case 22 : 
            {
                value = (java.lang.Double)(new java.lang.Double((((java.lang.Double)field_amount.getValue()).doubleValue() - ((java.lang.Double)variable_total.getEstimatedValue()).doubleValue()) * -1 ));//$JR_EXPR_ID=22$
                break;
            }
            case 23 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=23$
                break;
            }
            case 24 : 
            {
                value = (java.lang.Double)(new java.lang.Double( ((java.lang.Double)variable_sub_total.getEstimatedValue()).doubleValue() + (((java.lang.Double)variable_senior_citizen.getEstimatedValue()).doubleValue() +((java.lang.Double)variable_member.getEstimatedValue()).doubleValue()) ));//$JR_EXPR_ID=24$
                break;
            }
            case 25 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=25$
                break;
            }
            case 26 : 
            {
                value = (java.lang.Double)(new java.lang.Double(  (((java.lang.Double)variable_sub_total.getEstimatedValue()).doubleValue()) +(((java.lang.Double)variable_service_charge.getEstimatedValue()).doubleValue()) ));//$JR_EXPR_ID=26$
                break;
            }
            case 27 : 
            {
                value = (java.lang.Double)(new java.lang.Double(0.00));//$JR_EXPR_ID=27$
                break;
            }
            case 28 : 
            {
                value = (java.lang.Double)(new Double(  (((java.lang.Double)field_p.getValue()).doubleValue()) *(((java.lang.Integer)field_qty.getValue()).intValue()) ));//$JR_EXPR_ID=28$
                break;
            }
            case 29 : 
            {
                value = (java.lang.String)(((java.lang.String)field_tId.getValue()));//$JR_EXPR_ID=29$
                break;
            }
            case 30 : 
            {
                value = (java.lang.String)(((java.lang.String)variable_or_no.getEstimatedValue()));//$JR_EXPR_ID=30$
                break;
            }
            case 31 : 
            {
                value = (java.sql.Timestamp)(((java.sql.Timestamp)field_tDate.getValue()));//$JR_EXPR_ID=31$
                break;
            }
            case 32 : 
            {
                value = (java.lang.String)(((java.lang.String)variable_now.getEstimatedValue()));//$JR_EXPR_ID=32$
                break;
            }
            case 33 : 
            {
                value = (java.lang.Integer)(((java.lang.Integer)field_tNum.getValue()));//$JR_EXPR_ID=33$
                break;
            }
            case 34 : 
            {
                value = (java.lang.String)(((java.lang.String)field_cId.getValue()));//$JR_EXPR_ID=34$
                break;
            }
            case 35 : 
            {
                value = (java.lang.Integer)(((java.lang.Integer)field_qty.getValue()));//$JR_EXPR_ID=35$
                break;
            }
            case 36 : 
            {
                value = (java.lang.Double)(((java.lang.Double)field_p.getValue()));//$JR_EXPR_ID=36$
                break;
            }
            case 37 : 
            {
                value = (java.lang.String)(((java.lang.String)field_name.getValue()));//$JR_EXPR_ID=37$
                break;
            }
            case 38 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_amt.getEstimatedValue()));//$JR_EXPR_ID=38$
                break;
            }
            case 39 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_sub_total1.getEstimatedValue()));//$JR_EXPR_ID=39$
                break;
            }
            case 40 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_service_charge.getEstimatedValue()));//$JR_EXPR_ID=40$
                break;
            }
            case 41 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_senior_citizen.getEstimatedValue()));//$JR_EXPR_ID=41$
                break;
            }
            case 42 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_member.getEstimatedValue()));//$JR_EXPR_ID=42$
                break;
            }
            case 43 : 
            {
                value = (java.lang.Double)(((java.lang.Double)variable_total.getEstimatedValue()));//$JR_EXPR_ID=43$
                break;
            }
            case 44 : 
            {
                value = (java.lang.Double)(new java.lang.Double(  (((java.lang.Double)field_amount.getValue()).doubleValue()) * -1 ));//$JR_EXPR_ID=44$
                break;
            }
            case 45 : 
            {
                value = (java.lang.Double)(new java.lang.Double(  (((java.lang.Double)variable_total.getEstimatedValue()).doubleValue()) -(((java.lang.Double)field_amount.getValue()).doubleValue()) ));//$JR_EXPR_ID=45$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


}
