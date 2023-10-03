<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="jsp-components/head.jsp" %>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <%@include file="jsp-components/sidebar.jsp" %>

        
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <%@include file="jsp-components/topbar.jsp" %>
             

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Create AppUser</h1>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>
                    
                    <form class="user">
                                <div class="form-group col">
                                    <div class="col-sm-6 mb-3 ">
                                        <input type="text" class="form-control form-control-user"
                                            id="UserName" placeholder="UserName">
                                    </div>
                                    <div class="col-sm-6 mb-3">
                                        <input type="password" class="form-control form-control-user"
                                            id="Password" placeholder="Password">
                                    </div>
                                     <div class="col-sm-6 mb-3">
                                        <input type="text" class="form-control form-control-user"
                                            id="UserType" placeholder="User Type">
                                    </div>
                                </div>
                                <a href="#" class="btn btn-primary btn-user btn-block">
                                    Create Dentist
                                </a>
                                <hr>
                            </form>

            <!-- End of Main Content -->

            <%@include file="jsp-components/footer.jsp" %>
           
<%@include file="jsp-components/body-final.jsp" %>

</html>